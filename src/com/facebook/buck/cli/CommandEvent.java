/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.cli;

import com.facebook.buck.event.AbstractBuckEvent;
import com.facebook.buck.event.EventKey;
import com.google.common.collect.ImmutableList;

/**
 * Events tracking the start and stop of a buck command.
 */
public abstract class CommandEvent extends AbstractBuckEvent {
  private final String commandName;
  private final ImmutableList<String> args;
  private final boolean isDaemon;

  /**
   * @param commandName The name of the Buck subcommand, such as {@code build} or {@code test}.
   * @param args The arguments passed to the subcommand. These are often build targets.
   * @param isDaemon Whether the daemon was in use.
   */
  private CommandEvent(
      EventKey eventKey,
      String commandName,
      ImmutableList<String> args,
      boolean isDaemon) {
    super(eventKey);
    this.commandName = commandName;
    this.args = args;
    this.isDaemon = isDaemon;
  }

  public String getCommandName() {
    return commandName;
  }

  /** @return Arguments passed to {@link #getCommandName()}. */
  public ImmutableList<String> getArgs() {
    return args;
  }

  public boolean isDaemon() {
    return isDaemon;
  }

  @Override
  protected String getValueString() {
    return String.format("%s, isDaemon: %b", commandName, isDaemon);
  }

  public static Started started(String commandName, ImmutableList<String> args, boolean isDaemon) {
    return new Started(commandName, args, isDaemon);
  }

  public static Finished finished(Started started, int exitCode) {
    return new Finished(started, exitCode);
  }

  public static class Started extends CommandEvent {
    private Started(String commandName, ImmutableList<String> args, boolean isDaemon) {
      super(EventKey.unique(), commandName, args, isDaemon);
    }

    @Override
    public String getEventName() {
      return "CommandStarted";
    }
  }

  public static class Finished extends CommandEvent {
    private final int exitCode;

    private Finished(Started started,
        int exitCode) {
      super(started.getEventKey(), started.getCommandName(), started.getArgs(), started.isDaemon());
      this.exitCode = exitCode;
    }

    public int getExitCode() {
      return exitCode;
    }

    @Override
    public String getEventName() {
      return "CommandFinished";
    }
  }
}
