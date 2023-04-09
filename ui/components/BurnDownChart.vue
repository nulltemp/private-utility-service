<template>
  <div>
    <template v-for="burnDownChart in burnDownCharts" :key="burnDownChart.id">
      chart name: {{ burnDownChart.name }}
      <template v-for="burnDownChartValue in burnDownChartValues.get(burnDownChart.id)" :key="burnDownChartValue.date">
        date: {{ burnDownChartValue.date }}
        value: {{ burnDownChartValue.value }}
      </template>
      count per day: {{ countPerDay }}
      total days: {{ totalDays }}
    </template>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue"
import dayjs from 'dayjs'

const { data: response } = await useFetch<BurnDownCharts>("http://localhost:8080/charts/burn-down")

const burnDownCharts = ref(response.value !== null ? response.value.contents : [])

const burnDownChartValues = ref(new Map<Number, BurnDownChartValue[]>())
const to = dayjs().format("YYYY-MM-DD")
const from = dayjs().add(-1, "month").format("YYYY-MM-DD")
const countPerDay = ref(0)
const totalDays = ref(0)
if (burnDownCharts.value !== null) {
  for (let i = 0; i < burnDownCharts.value.length; i++) {
    const burnDownChart = burnDownCharts.value[i]
    const id = burnDownChart.id
    const { data: valueResponses } = await useFetch<BurnDownChartValues>(`http://localhost:8080/charts/burn-down/${id}/values?from=${from}&to=${to}`)
    burnDownChartValues.value.set(id, valueResponses.value !== null ? valueResponses.value.contents : [])

    if (valueResponses.value !== null && valueResponses.value.contents.length > 1) {
      const range = dayjs(valueResponses.value.contents[valueResponses.value.contents.length - 1].date).diff(valueResponses.value.contents[0].date)
      const diff = valueResponses.value.contents[valueResponses.value.contents.length - 1].value - valueResponses.value.contents[0].value
      countPerDay.value = diff / range

      if (countPerDay.value < 0) {
        totalDays.value = valueResponses.value.contents[valueResponses.value.contents.length - 1].value / countPerDay.value * -1
      }
    }
  }
}
</script>