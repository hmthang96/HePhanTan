const tuitionrouter = require('./tuition')
const siterouter = require('./site')

function route(app){

     app.use('/tuition',tuitionrouter);
     app.use('/',siterouter);
}

module.exports = route;