require "date"
require_relative "connect_db.rb"
$date = Date.today

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
    return (@due_date < date) ? true : false
  end

  def due_today?
    return (@due_date == date) ? true : false
  end

  def due_later?
    return (@due_date > date) ? true : false
  end

  def to_displayable_string
    str = (@completed) ? "[X]" : "[ ]"
    return "#{str} #{@text}"
  end
end

class Todos < ActiveRecord::Base
  def self.add_task(record)
    @todo = Todos.new(record)
    @todo.save
  end

  def self.show_list
    output = []
    Todos.all.map do |record|
      str = (record.completed) ? "[X]" : "[ ]"
      date = (record.completed) ? "" : record.due_date_todo
      output.push("#{record.id}  #{str}  #{record.todo_text}  #{record.due_date_todo}")
    end
    output
  end

  def to_displayable_string
    str = (self.completed) ? "[X]" : "[ ]"
    return "#{str} #{self.todo_text}"
  end

  def self.mark_as_complete(id)
    todo = Todos.find_by_id(id)
    todo.completed = true
    todo.save
    todo
  end
end

class TodosList
  attr_reader :todos

  def initialize(todos)
    @todos = todos
  end

  def self.all_records
    @todos = Todos.all
    @todos
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
    @todos.map do |record|
      str = (record.completion) ? "[X]" : "[ ]"
      output.push("#{record.id} #{str} #{record.text} #{record.due_date}")
    end
    output
  end
end
