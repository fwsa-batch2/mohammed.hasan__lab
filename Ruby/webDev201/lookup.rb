def get_command_line_argument
  if ARGV.empty?
    puts "Usage: ruby lookup.rb <domain>"
    exit
  end
  ARGV.first
end

# `domain` contains the domain name we have to look up.
domain = get_command_line_argument

file = File.open("C:\\Users\\hasan\\mohammed.hasan__lab\\Ruby\\webDev201\\zone.txt")
dns_raw = File.readlines(file)

def parse_dns(array)
  all_record_array = []
  hash = {}
  # For commented lines in file
  new_list = array.filter do |line|
    first_char = line[0, 1]
    (first_char == "#" || line.length < 3) ? false : true
  end
  new_list.each do |line|
    hash = { source: "", key: "", destination: "" }
    temp = line.strip.split(",")
    hash[:source] = temp[0].strip
    if (temp[0] == "A")
      is_digit = !!temp[2].match(/\d.\d.\d/)
      if (is_digit)
        hash[:destination] = temp[2].strip
        hash[:key] = temp[1].strip
      else
        hash[:destination] = temp[1].strip
        hash[:key] = temp[2].strip
      end
    else
      hash[:destination] = temp[2].strip
      hash[:key] = temp[1].strip
    end
    all_record_array.push(hash)
  end
  all_record_array
end

def resolve(dns_records, lookup_chain, domain)
  key = lookup_chain.last
  match_record = dns_records.select { |record| record[:key] == key }
  lookup_chain.push(match_record[0][:destination])
  (!!match_record[0][:destination].match(/\d.\d.\d/)) ? (return lookup_chain) : resolve(dns_records, lookup_chain, domain)
end

dns_records = parse_dns(dns_raw)
lookup_chain = [domain]
lookup_chain = resolve(dns_records, lookup_chain, domain)
puts "DNS Result : #{lookup_chain.join(" => ")}"
