const express = require('express')
const router = express.Router()

const tuitioncontroller = require('../controllers/TuitionController')


router.use('/', tuitioncontroller.index)

module.exports = router;