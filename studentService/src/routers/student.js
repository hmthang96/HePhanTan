const Router = require('express').Router();
const student = require('../controllers/student');
const { tryCatch } = require('../middleware/errorHandle');

Router.get('/getAll', tryCatch(student.getAll));
Router.post('/', tryCatch(student.create));

module.exports = Router;