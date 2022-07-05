const express = require('express');
const { PORT_SERVICE_STUDENT } = require('../../config');
const cors = require('cors');
const bodyParser = require('body-parser');
const app = express();

app.use(cors());
app.use(bodyParser.json());

const checkHealth = (req, res) => {
    res.send({
        status: 0,
        message: "Server Student alive!!!",
    })
};

app.get('/', checkHealth);

app.listen(PORT_SERVICE_STUDENT, err => {
    if (err) console.log(err);
    else console.log(`Service Student listen at ${PORT_SERVICE_STUDENT}`);
});
