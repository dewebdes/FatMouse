[recon-ng][fbi] > db schema
                   
  +---------------+
  |    domains    |
  +---------------+
  | domain | TEXT |
  | notes  | TEXT |
  | module | TEXT |
  +---------------+
                   
                   
  +--------------------+
  |     companies      |
  +--------------------+
  | company     | TEXT |
  | description | TEXT |
  | notes       | TEXT |
  | module      | TEXT |
  +--------------------+
                   
                   
  +-----------------+   
  |    netblocks    |   
  +-----------------+   
  | netblock | TEXT |   
  | notes    | TEXT |   
  | module   | TEXT |   
  +-----------------+   
                   
                   
  +-----------------------+
  |       locations       |
  +-----------------------+
  | latitude       | TEXT |
  | longitude      | TEXT |
  | street_address | TEXT |
  | notes          | TEXT |
  | module         | TEXT |
  +-----------------------+
                   
                   
  +---------------------+  
  |   vulnerabilities   |  
  +---------------------+  
  | host         | TEXT |  
  | reference    | TEXT |  
  | example      | TEXT |  
  | publish_date | TEXT |  
  | category     | TEXT |  
  | status       | TEXT |  
  | notes        | TEXT |
  | module       | TEXT |
  +---------------------+


  +-------------------+
  |       ports       |
  +-------------------+
  | ip_address | TEXT |
  | host       | TEXT |
  | port       | TEXT |
  | protocol   | TEXT |
  | banner     | TEXT |
  | notes      | TEXT |
  | module     | TEXT |
  +-------------------+


  +-------------------+
  |       hosts       |
  +-------------------+
  | host       | TEXT |
  | ip_address | TEXT |
  | region     | TEXT |
  | country    | TEXT |
  | latitude   | TEXT |
  | longitude  | TEXT |
  | notes      | TEXT |
  | module     | TEXT |
  +-------------------+


  +--------------------+
  |      contacts      |
  +--------------------+
  | first_name  | TEXT |
  | middle_name | TEXT |
  | last_name   | TEXT |
  | email       | TEXT |
  | title       | TEXT |
  | region      | TEXT |
  | country     | TEXT |
  | phone       | TEXT |
  | notes       | TEXT |
  | module      | TEXT |
  +--------------------+


  +-----------------+
  |   credentials   |
  +-----------------+
  | username | TEXT |
  | password | TEXT |
  | hash     | TEXT |
  | type     | TEXT |
  | leak     | TEXT |
  | notes    | TEXT |
  | module   | TEXT |
  +-----------------+


  +-----------------------------+
  |            leaks            |
  +-----------------------------+
  | leak_id              | TEXT |
  | description          | TEXT |
  | source_refs          | TEXT |
  | leak_type            | TEXT |
  | title                | TEXT |
  | import_date          | TEXT |
  | leak_date            | TEXT |
  | attackers            | TEXT |
  | num_entries          | TEXT |
  | score                | TEXT |
  | num_domains_affected | TEXT |
  | attack_method        | TEXT |
  | target_industries    | TEXT |
  | password_hash        | TEXT |
  | password_type        | TEXT |
  | targets              | TEXT |
  | media_refs           | TEXT |
  | notes                | TEXT |
  | module               | TEXT |
  +-----------------------------+


  +---------------------+
  |       pushpins      |
  +---------------------+
  | source       | TEXT |
  | screen_name  | TEXT |
  | profile_name | TEXT |
  | profile_url  | TEXT |
  | media_url    | TEXT |
  | thumb_url    | TEXT |
  | message      | TEXT |
  | latitude     | TEXT |
  | longitude    | TEXT |
  | time         | TEXT |
  | notes        | TEXT |
  | module       | TEXT |
  +---------------------+


  +-----------------+
  |     profiles    |
  +-----------------+
  | username | TEXT |
  | resource | TEXT |
  | url      | TEXT |
  | category | TEXT |
  | notes    | TEXT |
  | module   | TEXT |
  +-----------------+


  +--------------------+
  |    repositories    |
  +--------------------+
  | name        | TEXT |
  | owner       | TEXT |
  | description | TEXT |
  | resource    | TEXT |
  | category    | TEXT |
  | url         | TEXT |
  | notes       | TEXT |
  | module      | TEXT |
  +--------------------+

