class SiteController{
    //[GET] /
    index(req, res){
        res.send('Home')
    }

}

module.exports = new SiteController;