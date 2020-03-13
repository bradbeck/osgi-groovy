<!--

    Copyright (c) 2020-present Brad Beck All rights reserved.

    This program is licensed to you under the Apache License Version 2.0,
    and you may not use this file except in compliance with the Apache License Version 2.0.
    You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.

    Unless required by applicable law or agreed to in writing,
    software distributed under the Apache License Version 2.0 is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.

-->
# Table of Contents

* [Installing in Karaf](#installing-in-karaf)

## Installing in Karaf
```
feature:repo-add mvn:com.example.jowambi/com.example.jowambi.features/1.0.0-SNAPSHOT/xml/features
feature:install com.example.jowambi.features
```

## Example Usage
```
$ bin/karaf
        __ __                  ____
       / //_/____ __________ _/ __/
      / ,<  / __ `/ ___/ __ `/ /_
     / /| |/ /_/ / /  / /_/ / __/
    /_/ |_|\__,_/_/   \__,_/_/

  Apache Karaf (4.2.8)

Hit '<tab>' for a list of available commands
and '[cmd] --help' for help on a specific command.
Hit '<ctrl-d>' or type 'system:shutdown' or 'logout' to shutdown Karaf.

karaf@root()> feature:repo-add mvn:com.example.jowambi/com.example.jowambi.features/1.0.0-SNAPSHOT/xml/features
Adding feature url mvn:com.example.jowambi/com.example.jowambi.features/1.0.0-SNAPSHOT/xml/features
karaf@root()> feature:install com.example.jowambi.features
karaf@root()> jowambi:json
{"one":"1","two":"2","three":"3"}
karaf@root()> jowambi:groove
foo
karaf@root()>
```
