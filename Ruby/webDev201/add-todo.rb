require_relative "./connect_db.rb"
require_relative "./todo.rb"

def get_new_todo
  puts "Todo text:"
  todo_text = gets.strip
  return nil if todo_text.empty?

  puts "How many days from now is it due? (give an integer value)"
  due_in_days = gets.strip.to_i

  {
    todo_text: todo_text,
    due_date_todo: Date.today + due_in_days,
    completed: false,
  }
end

puts Date.today + 1

h = get_new_todo
if h
  new_todo = Todos.add_task(h)
  #   puts "New todo created with id #{new_todo.id}"
  Todos.show_list
end
