const express = require('express')
const router = express.Router()

const sitecontroller = require('../controllers/SiteController')


router.use('/', sitecontroller.index)

module.exports = router;