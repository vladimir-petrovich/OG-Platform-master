/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.bond;

import com.opengamma.analytics.util.amount.ReferenceAmount;
import com.opengamma.financial.analytics.model.fixedincome.BucketedCurveSensitivities;
import com.opengamma.sesame.Environment;
import com.opengamma.sesame.OutputNames;
import com.opengamma.sesame.function.Output;
import com.opengamma.sesame.trade.BondTrade;
import com.opengamma.util.money.Currency;
import com.opengamma.util.money.MultipleCurrencyAmount;
import com.opengamma.util.result.Result;
import com.opengamma.util.tuple.Pair;

/**
 * General interface for bond.
 */
public interface BondFn {

  /**
   * Calculate the present value of bond transaction by discounting the cash flows using an issuer specific curve.
   *
   * @param env the environment that the PV will be calculate with.
   * @param bondTrade the bond trade to calculate the PV for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.PRESENT_VALUE_CURVES)
  Result<MultipleCurrencyAmount> calculatePresentValueFromCurves(Environment env, BondTrade bondTrade);

  /**
   * Calculates the present value of a bond from its market quoted price, which applies to instruments 
   * quoted in price. The present value function will scale the market price by the bond size and add 
   * any accrued interest into the final result.
   *
   * @param env the environment that the PV will be calculate with.
   * @param bondTrade the bond trade to calculate the PV for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.PRESENT_VALUE_CLEAN_PRICE)
  Result<MultipleCurrencyAmount> calculatePresentValueFromCleanPrice(Environment env, BondTrade bondTrade);

  /**
   * Calculates the present value of a bond from its market quoted price, which applies to instruments 
   * quoted in yield, such as bills. The present value function will scale the market price by the bond 
   * size and add any accrued interest into the final result.
   *
   * @param env the environment that the PV will be calculate with.
   * @param bondTrade the bond trade to calculate the PV for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.PRESENT_VALUE_YIELD)
  Result<MultipleCurrencyAmount> calculatePresentValueFromYield(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Market Clean Price of a bond. Returns the quoted price without modification.
   *
   * @param env the environment that the Market Clean Price will be calculate with.
   * @param bondTrade the bond trade to calculate the Market Clean Price for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.CLEAN_PRICE_MARKET)
  Result<Double> calculateCleanPriceMarket(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Clean Price of a bond from the curves.
   *
   * @param env the environment that the Market Clean Price will be calculate with.
   * @param bondTrade the bond trade to calculate the Market Clean Price for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.CLEAN_PRICE_CURVES)
  Result<Double> calculateCleanPriceFromCurves(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Clean Price of a bond from the quoted yield.
   *
   * @param env the environment that the Market Clean Price will be calculate with.
   * @param bondTrade the bond trade to calculate the Market Clean Price for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.CLEAN_PRICE_YIELD)
  Result<Double> calculateCleanPriceFromYield(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Yield To Maturity of a bond. Returns the quoted yield without modification.
   *
   * @param env the environment that the Yield To Maturity will be calculate with.
   * @param bondTrade the bond trade to calculate the Yield To Maturity for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.YIELD_TO_MATURITY_CLEAN_PRICE)
  Result<Double> calculateYieldToMaturityFromCleanPrice(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Yield To Maturity of a bond. Returns the quoted yield without modification.
   *
   * @param env the environment that the Yield To Maturity will be calculate with.
   * @param bondTrade the bond trade to calculate the Yield To Maturity for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.YIELD_TO_MATURITY_CURVES)
  Result<Double> calculateYieldToMaturityFromCurves(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Yield To Maturity of a bond. Returns the quoted yield without modification.
   *
   * @param env the environment that the Yield To Maturity will be calculate with.
   * @param bondTrade the bond trade to calculate the Yield To Maturity for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.YIELD_TO_MATURITY_MARKET)
  Result<Double> calculateYieldToMaturityMarket(Environment env, BondTrade bondTrade);

  /**
   * Calculate the bucketed PV01 of a bond.
   *
   *
   * @param env the environment that the bucketed PV01 will be calculate with.
   * @param bondTrade the bond trade to calculate the bucketed PV01 for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.BUCKETED_PV01)
  Result<BucketedCurveSensitivities> calculateBucketedPV01(Environment env, BondTrade bondTrade);

  /**
   * Calculate the PV01 of a bond.
   *
   * @param env the environment that the PV01 will be calculate with.
   * @param bondTrade the bond trade to calculate the PV01 for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.PV01)
  Result<ReferenceAmount<Pair<String, Currency>>> calculatePV01(Environment env, BondTrade bondTrade);

  /**
   * Calculate the Z-Spread of a bond.
   *
   * @param env the environment that the Z-Spread will be calculate with.
   * @param bondTrade the bond trade to calculate the Z-Spread for.
   * @return result containing the present value if successful, a Failure otherwise.
   */
  @Output(OutputNames.Z_SPREAD)
  Result<Double> calculateZSpread(Environment env, BondTrade bondTrade);

}
