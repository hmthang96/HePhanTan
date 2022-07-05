const express = require('express');
const app = express();
const proxy = require('express-http-proxy');
const cors = require('cors');

const { 
    API_URL, 
    PORT_GATEWAY, 
    PORT_SERVICE_AUTH, 
    PORT_SERVICE_STUDENT 
} = require('../../config');

app.use(cors());

const checkHealth = (req, res) => {
    res.send({
        status: 0,
        message: 'GateWay Server alive!!!',
    })
}

app.get('/', checkHealth);
app.use('/auth', proxy(`${API_URL}:${PORT_SERVICE_AUTH}`));
app.use('/student', proxy(`${API_URL}:${PORT_SERVICE_STUDENT}`));

app.listen(PORT_GATEWAY, err => {
    if (err) console.log(err);
    else console.log(`app listen att ${PORT_GATEWAY}`);
})