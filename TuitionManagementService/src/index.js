const path = require('path')
const express = require('express')
// const XLSX = require('xlsx')
// const file = XLSX.readFile(__dirname + '/public/tuition-list.xlsx')
const morgan = require('morgan')
const app = express()
const port = 3000

const route = require('./routes/RoutesIndex')

app.use(morgan('combined'))

// app.get("/",(req,res) => {
//   const sheets = file.SheetNames;

//   const data = [];
//   for (let i = 0; i < sheets.length; i++)
//   {
//     const sheetname = sheets[i];

//     const sheetdata = XLSX.utils.sheet_to_json(file.Sheets[sheetname]);

//     sheetdata.forEach((a) => {
//       data.push(a);
//     });
//   }
//   console.log(data);
//   res.send(data);
// })

//routes init
route(app);

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})