type BurnDownChart = {
  id: Number,
  name: String
}

type BurnDownCharts = {
  contents: Array<BurnDownChart>
}

type BurnDownChartValue = {
  id: Number,
  burnDownChartId: Number,
  date: String,
  value: Number
}

type BurnDownChartValues = {
  contents: Array<BurnDownChartValue>
}