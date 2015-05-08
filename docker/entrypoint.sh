#!/bin/bash

# sed & copy xml config, zmienic port na ENV PORT0
cat /opt/glassfish4/glassfish/domains/domain1/config/domain.xml.org | sed -e "s/OPW_HTTP/${PORT0}/g" | sed -e "s/OPW_ADMIN/${PORT1}/g" > /opt/glassfish4/glassfish/domains/domain1/config/domain.xml ;
#cat /opt/glassfish4/glassfish/domains/domain1/config/domain.xml | sed -e "s/OPW_ADMIN/${PORT1}/g" > /opt/glassfish4/glassfish/domains/domain1/config/domain.xml ;

/opt/glassfish4/glassfish/bin/asadmin start-domain --verbose

# glasfish start
