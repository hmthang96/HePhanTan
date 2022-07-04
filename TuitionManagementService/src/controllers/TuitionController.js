class TuitionController{
    //[GET] /tuition
    index(req, res){
        res.send('tuition');
    }

}

module.exports = new TuitionController;