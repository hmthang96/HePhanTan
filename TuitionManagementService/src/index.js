const path = require('path')
const express = require('express')
const XLSX = require('xlsx')
const file = XLSX.readFile('./public/tuition-list.xlsx')
const morgan = require('morgan')
const app = express()
const port = 3000

const route = require('./routes/RoutesIndex')

app.use(morgan('combined'))

app.get("/",(req,res) => {
  console.log(file);
})
//routes init
route(app);

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})