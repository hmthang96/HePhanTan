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

const getById = async (req, res) => {
    const { id } = req.params;
    const result = await student.getById(id);

    res.status(200).send(result);
}

const update = async (req, res) => {
    const {id} = req.params;
    const result = await student.update(req.body, id);

    res.status(200).send(result);
}

const deleteById = async (req, res) => {
    const {id} = req.params;
    const result = await student.deleteById(id);

    res.status(200).send(result);
}

module.exports = {
    getAll,
    getById,
    create,
    update,
    deleteById
}