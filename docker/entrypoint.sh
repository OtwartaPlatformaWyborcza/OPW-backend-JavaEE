#!/bin/bash

# PORT0 - HTTP 
# PORT1 - admin
# PORT0 - JMS (auto offset +100)
cat /opt/glassfish4/glassfish/domains/domain1/config/domain.xml.org | sed -e "s/OPW_HTTP/${PORT0}/g" | sed -e "s/OPW_ADMIN/${PORT1}/g" | sed -e "s/OPW_JMS/${PORT0}/g" > /opt/glassfish4/glassfish/domains/domain1/config/domain.xml ;

/opt/glassfish4/glassfish/bin/asadmin start-domain --verbose

# glasfish start
