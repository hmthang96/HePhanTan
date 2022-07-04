
// const XLSX = require('xlsx')
// const file = XLSX.readFile(__dirname + '/public/tuition-list.xlsx')
class TuitionController{
    //[GET] /tuition
    // index(req, res)
    // {
    //     const sheets = file.SheetNames;

    //     const data = [];
    //     for (let i = 0; i < sheets.length; i++)
    //     {
    //       const sheetname = sheets[i];
      
    //       const sheetdata = XLSX.utils.sheet_to_json(file.Sheets[sheetname]);
      
    //       sheetdata.forEach((a) => {
    //         data.push(a);
    //       });
    //     }
    //     console.log(data);
    //     res.send(data);
    // }

    index(req,res){
        res.send('tuition')
    }

}

module.exports = new TuitionController;
