require "active_record"

def connect_db!
  ActiveRecord::Base.establish_connection(
    host: "localhost",
    port: 3306,
    adapter: "mysql2",
    database: "ruby",
    username: "hasan",
    password: "HasanTheDON7.",
  )
  puts "Connected"
end

connect_db!
