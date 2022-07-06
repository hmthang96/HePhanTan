const Router = require('express').Router();
const student = require('../controllers/student');
const { tryCatch } = require('../middleware/errorHandle');

Router.get('/getAll', tryCatch(student.getAll));
Router.post('/', tryCatch(student.create));
Router.get('/:id', tryCatch(student.getById));
Router.put('/:id', tryCatch(student.update));
Router.delete('/:id', tryCatch(student.deleteById))

module.exports = Router;