require 'thread'
require 'thwait'


=begin 
    In Ruby, Main thread ends after it finishes its job. So we need to make it wait
 till other threads complete their job. Otherwise, the threads will execute as much as it can, 
 as long as main thread is alive.
=end
threadsArray = []
thread = Thread.new {
    5.times do |n|
        puts "i from thread-1 is #{n}"
        sleep(0.5)
    end  
}

thread2 = Thread.new {
    5.times do |n|
        puts "i from thread-2 is #{n}"
        sleep(0.5)
    end
}
threadsArray << thread
threadsArray << thread2

# thread.join

puts "This is start of Main"
# Both the below lines are same
# threadsArray.map(&:join)
ThreadsWait.all_waits(*threadsArray)

puts "This is End of Main"
