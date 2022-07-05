const db = require('../utilities/db');

const getAll = async () => {
    const sql = `select * from Student`;
    const countSql = `select count(mssv) as total from Student`;

    const total = await db.queryOne(countSql);
    const data = await db.query(sql);
    return {
        total: total[0].total,
        data
    };
};

const create = async (mssv, name, age, email, className, adress) => {
    const checkSql = `select count(mssv) as size from Student where mssv = ?`;
    const checkExists = await db.queryOne(checkSql, [mssv]);

    if (checkExists[0].size > 0) {
        return {
            status:1,
            message: 'Mã số sinh viên đã tồn tại',
        }
    }

    const sql = `insert into Student(mssv, name, age, email, className, adress) values(?,?,?,?,?,?)`;

    await db.queryOne(sql, [mssv, name, age, email, className, adress]);
    return {
        status:0,
        message: 'Tạo sinh viên thành công',
    }
};

module.exports = {
    getAll,
    create
};
