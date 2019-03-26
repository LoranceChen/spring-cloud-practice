#!/bin/bash

wrk -t3 -c20 -d10s --script=wrk-post.lua http://localhost:6103/consumer-provider-info
