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
  hash = {}
  # For commented lines in file
  if (array[0][0, 1] == "#")
    array = array.drop(1)
  end
  array.each do |line|
    temp = []
    temp = line.strip.split(", ")
    # leaving 1st column (A, CNAME) and creating a hash of other columns
    hash[temp[1]] = temp[2]
  end
  hash.compact
end

def resolve(dns_records, lookup_chain, domain)
  if (domain == "google.com" || domain == "ruby-lang.org")
    lookup_chain.push(dns_records[domain])
    return lookup_chain
  else
    key = lookup_chain.last
    if (dns_records.has_key?(key))
      lookup_chain.push(dns_records[key])
      resolve(dns_records, lookup_chain, domain)
      lookup_chain
    end
  end
end

dns_records = parse_dns(dns_raw)
lookup_chain = [domain]
lookup_chain = resolve(dns_records, lookup_chain, domain)
puts lookup_chain.join(" => ")
