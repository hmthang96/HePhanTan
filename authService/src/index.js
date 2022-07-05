const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const { PORT_SERVICE_AUTH } = require('../../config'); 

app.use(bodyParser.json());
const account = require('./routers/account');
const auth = require('./routers/auth');

const checkHealth = (req, res)=> {
    res.send({
        status: 0,
        message: 'Server Auth alive!!!',
    });
};

app.use('/auth', auth);
app.use('/account', account);
app.get('/', checkHealth);

app.listen(PORT_SERVICE_AUTH, err => {
    if (err) console.log(err);
    // else console.log('\x1b[32m',`app listen at ${PORT}`);
    else console.log(`Service Auth listen at ${PORT_SERVICE_AUTH}`);
})

