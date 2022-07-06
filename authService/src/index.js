const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const proxy = require('express-http-proxy');
const cors = require('cors'); 
const { 
    API_URL, 
    PORT_GATEWAY, 
    PORT_SERVICE_AUTH, 
    PORT_SERVICE_STUDENT 
} = require('../../config');
const { reqLogin, reqRole } = require('./middleware/auth');

app.use(bodyParser.json());
app.use(cors());
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
app.use('/student', reqLogin, proxy(`${API_URL}:${PORT_SERVICE_STUDENT}`));

app.listen(PORT_SERVICE_AUTH, err => {
    if (err) console.log(err);
    // else console.log('\x1b[32m',`app listen at ${PORT}`);
    else console.log(`Service Auth listen at ${PORT_SERVICE_AUTH}`);
})

