const student = require('../services/student');

const getAll = async (req, res) => {
    const data = await student.getAll();
    
    res.status(200).send(data);
}

module.exports = {
    getAll
}