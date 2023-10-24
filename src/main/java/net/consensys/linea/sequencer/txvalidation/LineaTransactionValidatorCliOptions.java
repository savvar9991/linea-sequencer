/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package net.consensys.linea.sequencer.txvalidation;

import com.google.common.base.MoreObjects;
import picocli.CommandLine;

/** The Linea CLI options. */
public class LineaTransactionValidatorCliOptions {

  public static final String DENY_LIST_PATH = "--plugin-linea-deny-list-path";
  public static final String DEFAULT_DENY_LIST_PATH = "lineaDenyList.txt";

  @CommandLine.Option(
      names = {DENY_LIST_PATH},
      hidden = true,
      paramLabel = "<STRING>",
      description =
          "Path to the file containing the deny list (default: " + DEFAULT_DENY_LIST_PATH + ")")
  private String denyListPath = DEFAULT_DENY_LIST_PATH;

  private LineaTransactionValidatorCliOptions() {}

  /**
   * Create Linea cli options.
   *
   * @return the Linea cli options
   */
  public static LineaTransactionValidatorCliOptions create() {
    return new LineaTransactionValidatorCliOptions();
  }

  /**
   * Cli options from config.
   *
   * @param config the config
   * @return the cli options
   */
  public static LineaTransactionValidatorCliOptions fromConfig(
      final LineaTransactionValidatorConfiguration config) {
    final LineaTransactionValidatorCliOptions options = create();
    options.denyListPath = config.denyListPath();

    return options;
  }

  /**
   * To domain object Linea factory configuration.
   *
   * @return the Linea factory configuration
   */
  public LineaTransactionValidatorConfiguration toDomainObject() {
    return new LineaTransactionValidatorConfiguration(denyListPath);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add(DENY_LIST_PATH, denyListPath).toString();
  }
}