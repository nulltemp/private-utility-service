type BurnDownChart = {
  id: number,
  name: string
}

type BurnDownCharts = {
  contents: Array<BurnDownChart>
}

type BurnDownChartValue = {
  burnDownChartId: Number,
  date: string,
  value: number
}

type BurnDownChartValues = {
  contents: Array<BurnDownChartValue>
}