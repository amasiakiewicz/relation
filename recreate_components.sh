#!/bin/bash
#This is a script to recreate a docker image with postgres. You should invoke it from the parent dir.
docker-compose rm -svf db && docker-compose up -d db
