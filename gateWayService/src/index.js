const express = require('express');
const app = express();
const { 
    API_URL, 
    PORT_GATEWAY, 
    PORT_SERVICE_AUTH, 
    PORT_SERVICE_STUDENT 
} = require('../../config');

const checkHealth = (req, res) => {
    res.send({
        status: 0,
        message: 'GateWay Server alive!!!',
    })
}

app.get('/', checkHealth);

app.listen(PORT_GATEWAY, err => {
    if (err) console.log(err);
    else console.log(`app listen att ${PORT_GATEWAY}`);
})