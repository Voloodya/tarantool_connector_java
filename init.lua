box.cfg{ listen = '127.0.0.1:3301' }
box.schema.user.grant('guest','super', nil, nil, { if_not_exists = true })
box.schema.create_space('test', { if_not_exists = true })
box.space.test:format({
{name = "id", type = "integer"},
{name = "type", type = "string"},
})
box.space.test:create_index('primary', { if_not_exists = true })
require('console').start()
os.exit()