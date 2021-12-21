conn = require('net.box').connect('0.0.0.0:3301')
conn: eval('box.space.test:insert({1, "one"})')
conn: eval('box.space.test:insert({2, "two"})')
conn: eval('box.space.test:insert({3, "three"})')
