const student = require('../services/student');

const getAll = async (req, res) => {
    const data = await student.getAll();
    
    res.status(200).send(data);
};

const create = async (req, res) => {
    const { mssv, name, age, email, className, adress } = req.body;

    const result = await student.create(mssv, name, age, email, className, adress);

    res.status(200).send(result);
};

module.exports = {
    getAll,
    create
}