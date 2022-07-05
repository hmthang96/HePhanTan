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

module.exports = {
    getAll
};
