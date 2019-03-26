/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.packt.tfesenko;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class MyBenchmark {

	@Benchmark
	public void testCreateHashMapThenPut(Blackhole blackhole) {
		Map<String, String> map = new HashMap<>();
		map.put("Caesar", "Likes swimming");
		map.put("Snoopy", "Likes jumping");
		blackhole.consume(map);
	}

	@Benchmark
	public void testCreateHashMapAndPutInInitialization(Blackhole blackhole) {
		Map<String, String> map = new HashMap<>() {
			{
				put("Caesar", "Likes swimming");
				put("Snoopy", "Likes jumping");
			}
		};
		blackhole.consume(map);
	}

	@Benchmark
	public void testJava9MapOf(Blackhole blackhole) {
		var map = Map.of(//
				"Caesar", "Likes swimming", //
				"Snoopy", "Likes jumping");
		blackhole.consume(map);
	}

	@Benchmark
	public void testJava9MapOfEntriesMethod(Blackhole blackhole) {
		var map = Map.ofEntries(//
				Map.entry("Caesar", "Likes swimming"), //
				Map.entry("Snoopy", "Likes jumping"));
		blackhole.consume(map);
	}

}
