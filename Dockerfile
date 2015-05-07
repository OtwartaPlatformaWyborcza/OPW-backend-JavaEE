FROM        ubuntu

ENV         JAVA_HOME         /usr/lib/jvm/java-8-oracle
ENV         GLASSFISH_HOME    /opt/glassfish4
ENV         PATH              $PATH:$JAVA_HOME/bin:$GLASSFISH_HOME/bin

	    
RUN         apt-get update && \
	    apt-get install software-properties-common --yes && \
	    add-apt-repository ppa:webupd8team/java && \
	    apt-get update && \           
            apt-get install -y curl unzip zip inotify-tools

RUN 	echo "===> install Java"  && \
    	echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections  && \
    	echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections  && \
	DEBIAN_FRONTEND=noninteractive  apt-get install -y --force-yes oracle-java8-installer oracle-java8-set-default 

RUN         curl -L -o /tmp/glassfish-4.1.zip http://download.java.net/glassfish/4.1/release/glassfish-4.1.zip && \
            unzip /tmp/glassfish-4.1.zip -d /opt && \
            rm -f /tmp/glassfish-4.1.zip


COPY		./opw/target/xconfig/*	/opt/glassfish4/glassfish/domains/domain1/config/
COPY		./opw/target/xlib/*	/opt/glassfish4/glassfish/domains/domain1/lib/
COPY		./opw/target/opw.war 	/opt/glassfish4/glassfish/domains/domain1/autodeploy/

COPY 		./docker/entrypoint.sh /

WORKDIR		/opt/glassfish4

RUN		chmod +x /entrypoint.sh


