const express = require('express');

const app = express();

//Static
app.use('/public', express.static('public'));
 app.use( express.static('public'));

//Default body-parser
app.use(express.urlencoded());
require('./middlewares/dbLocal.mdw')(app);
require('./middlewares/session.mdw')(app);
require('./middlewares/passport.mdw')(app);
require('./middlewares/local.mdw')(app);
require('./middlewares/view.mdw')(app);require('./middlewares/route.mdw')(app);
require('./middlewares/error.mdw')(app);
require('./middlewares/paypal.mdw')(app);
require('./middlewares/cloudinary.mdw')(app);


app.listen(8000, console.log('Server running on port 8000'));

// const express = require("express");

// const app = express();

// require("./middlewares/dbLocal.mdw")(app);
// require("./middlewares/cloudinary.mdw")(app);
// const Course = require("./models/Course.model");
// const FaceBookUser = require("./models/FaceBookUser.model");
// const Lecturer = require("./models/Lecturer.model");
// const LocalUser = require("./models/LocalUser.model");
// const CourseCategory = require("./models/CourseCategory.model");
// const CategoryEnum = require("./models/CourseCategory.enum");
// const TopicEnum = require("./models/CourseTopic.enum");
// const CourseTopic = require("./models/CourseTopic.model");
// const cloudinary = require("cloudinary").v2;

// Course.findOne({_id: '60047f3899dbc32298745e80'}).then((doc)=>{
//     doc.numberOfVideo = 4;
//     doc.videos = [{
//         name: 'Machine learning overview',
//         source: 'https://res.cloudinary.com/teamwebctt2/video/upload/v1610988326/webctt2/video/machineLearning/1_z97lxw.mp4'
//     }, {
//         name: 'First application',
//         source: 'https://res.cloudinary.com/teamwebctt2/video/upload/v1610988326/webctt2/video/machineLearning/2_pne144.mp4'
//     }, {
//         name: 'Finding algorithm',
//         source: 'https://res.cloudinary.com/teamwebctt2/video/upload/v1610988326/webctt2/video/machineLearning/3_io1o37.mp4'
//     }, {
//         name: 'End course',
//         source: 'https://res.cloudinary.com/teamwebctt2/video/upload/v1610988326/webctt2/video/machineLearning/4_jm9lkt.mp4'
//     }];
//     doc.save().then(console.log('saved'));
// });


// Course.insertMany([{
//     name: 'Sales Summer Poster',
//     poster: '',
//     description: 'B???n c?? th??? h???c m???i th??? v??? Sales qua kh??a h???c c???a ch??ng t??i',
//     evaluationPoint: 0,
//     numberOfStudent: 0,
//     tuition: 10,
//     numberOfView: 0,
//     idCourseTopic: '5ff2e1c9ac3567138849dbe9', //Dev data
//     idLecturer: '5fed6330aba5d81fc019f9b7',
//     videos: [],
//     previewIndex: [0, 1, 2],
//     whatYoullLearn: [
//         'C?? hi???u bi???t chuy??n s??u v??? ng??n ng??? l???p tr??nh.',
//         'C?? k??? n??ng v?? hi???u bi???t v??? m???i th??? ????? t??? tin ???ng tuy???n v??o c??c c??ng vi???c l???p tr??nh.',
//         'Hi???u c??ch t???o c??c ch????ng tr??nh c???a ri??ng b???n.',
//         'H???c xong ?????m b???o tr??m l???p tr??nh'
//     ]
// }]).then(console.log("saved"));
