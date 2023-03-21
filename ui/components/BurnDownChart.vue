<template>
  <div>
    <template v-for="burnDownChart in burnDownCharts" :key="burnDownChart.id">
      chart name: {{ burnDownChart.name }}
      <template v-for="burnDownChartValue in burnDownChartValues.get(burnDownChart.id)" :key="burnDownChartValue.id">
        date: {{ burnDownChartValue.date }}
        value: {{ burnDownChartValue.value }}
      </template>
    </template>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue"
const { data: response } = await useFetch<BurnDownCharts>("http://localhost:8080/charts/burn-down")

const burnDownCharts = ref(response.value !== null ? response.value.contents : [])

const burnDownChartValues = ref(new Map<Number, BurnDownChartValue[]>())
if (burnDownCharts.value !== null) {
  for (let i = 0; i < burnDownCharts.value.length; i++) {
    const burnDownChart = burnDownCharts.value[i]
    const id = burnDownChart.id
    const { data: valueResponses } = await useFetch<BurnDownChartValues>(`http://localhost:8080/charts/burn-down/${id}/values?from=2023-02-21&to=2023-03-21`)
    burnDownChartValues.value.set(id, valueResponses.value !== null ? valueResponses.value.contents : [])
  }
}
</script>