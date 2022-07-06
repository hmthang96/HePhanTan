const db = require('../utilities/db'); 

const getAll = async () => {
    const sql = `select * from Student`;
    const countSql = `select count(mssv) as total from Student`;

    const total = await db.queryOne(countSql);
    const data = await db.query(sql);
    return {
        status: 0,
        total: total[0].total,
        data
    };
};

const getById = async (id) => {
    const sql = `select * from Student where mssv = ?`;
    const data = await db.queryOne(sql, [id]);
    return {
        status: 0,
        data
    };
}

const create = async (mssv, name, age, email, className, adress) => {
    const checkSql = `select count(mssv) as size from Student where mssv = ?`;
    const checkExists = await db.queryOne(checkSql, [mssv]);

    if (checkExists[0].size > 0) {
        return {
            status:1,
            message: 'Mã số sinh viên đã tồn tại!',
        }
    }

    const sql = `insert into Student(mssv, name, age, email, className, adress) values(?,?,?,?,?,?)`;

    await db.queryOne(sql, [mssv, name, age, email, className, adress]);
    return {
        status:0,
        message: 'Tạo sinh viên thành công!',
    }
};

const update = async ({name, age, email, className, adress}, id) => {
    const sql = `
        update Student
        set
        name = ?,
        age = ?,
        email = ?,
        className = ?,
        adress = ?
        where mssv = ?
    `
    
    await db.queryOne(sql, [name, age, email, className, adress, id]);
    return {
        status: 0,
        message: 'Cập nhật sinh viên thành công!',
    }
};

const deleteById = async (id) => {
    const sql = `delete from Student where mssv = ?`;

    await db.queryOne(sql, [id]);

    return {
        status: 0,
        message: 'Xoá sinh viên thành công !',
    }
};

module.exports = {
    getAll,
    create,
    getById,
    update,
    deleteById
};
