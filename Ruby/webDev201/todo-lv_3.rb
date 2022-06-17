require "date"
require_relative "connect_db.rb"
date = Date.today

class Todo
  attr_accessor :text
  attr_accessor :due_date
  attr_accessor :completion

  def initialize(text, due_date, completion)
    @text = text
    @due_date = due_date
    @completion = completion
  end

  def overdue?
    date = Date.today
    # puts date
    return (@due_date < date) ? true : false
  end

  def due_today?
    date = Date.today

    return (@due_date == date) ? true : false
  end

  def due_later?
    date = Date.today

    return (@due_date > date) ? true : false
  end

  def to_displayable_string
    str = (@completed) ? "[X]" : "[ ]"
    return "#{str} #{@text}"
  end
end

class TodosList
  def initialize(todos)
    @todos = todos
  end

  def add(record)
    @todos.push(record)
  end

  def overdue
    TodosList.new(@todos.filter { |todo| todo.overdue? })
  end

  def due_today
    TodosList.new(@todos.filter { |todo| todo.due_today? })
  end

  def due_later
    TodosList.new(@todos.filter { |todo| todo.due_later? })
  end

  def to_displayable_list
    output = []

    @todos.map do |rec|
      str = (rec.completion) ? "[X]" : "[ ]"
      output.push("#{str} #{rec.text} #{rec.due_date}")
    end

    output
  end
end

todos = [
  { text: "Submit assignment", due_date: date - 1, completed: false },
  { text: "Pay rent", due_date: date, completed: true },
  { text: "File taxes", due_date: date + 1, completed: false },
  { text: "Call Acme Corp.", due_date: date + 1, completed: false },
]
todos = todos.map { |todo| Todo.new(todo[:text], todo[:due_date], todo[:completed]) }

todos_list = TodosList.new(todos)

todos_list.add(Todo.new("Service vehicle", date, false))

puts "My Todo-list\n\n"

puts "Overdue\n"
puts todos_list.overdue.to_displayable_list
puts "\n\n"

puts "Due Today\n"
puts todos_list.due_today.to_displayable_list
puts "\n\n"

puts "Due Later\n"
puts todos_list.due_later.to_displayable_list
puts "\n\n"
