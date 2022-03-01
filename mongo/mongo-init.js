db.auth('admin', 'AdminP@s5w0rd')
db = db.getSiblingDB('testdb')
db.createUser({
        user: 'testuser',
        pwd: 'testpassword',
        roles:[
        {
                role:'readWrite',
                db:'testdb',
        }
        ]
});
// db.users.insert({"username": "admin", "password": "$2y$10$4O8VpVFMLlpo6PfrEFpDlOEW/HmFTIWVSzSsBa6oWOTqGkGzfv8RS", "roles": ['admin']})
