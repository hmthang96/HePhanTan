const express = require('express')
const { compile } = require('morgan')
const morgan = require('morgan')
const app = express()
const port = 3000

app.use(morgan('combined'))

app.get('/', (req, res) => {
  res.send('Hello World!   123')
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})