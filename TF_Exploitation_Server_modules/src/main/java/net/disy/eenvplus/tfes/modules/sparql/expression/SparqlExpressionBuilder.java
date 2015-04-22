//Copyright (c) 2014 by Disy Informationssysteme GmbH
package net.disy.eenvplus.tfes.modules.sparql.expression;

import com.hp.hpl.jena.sparql.expr.E_LogicalAnd;
import com.hp.hpl.jena.sparql.expr.E_LogicalOr;
import com.hp.hpl.jena.sparql.expr.Expr;
import com.hp.hpl.jena.sparql.syntax.ElementFilter;

// NOT_PUBLISHED
public class SparqlExpressionBuilder {

  private Expr current;

  private SparqlExpressionBuilder(Expr expression) {
    this.current = expression;
  }

  public static SparqlExpressionBuilder use(Expr expression) {
    return new SparqlExpressionBuilder(expression);
  }

  public Expr toExpr() {
    return current;
  }

  public ElementFilter toElementFilter() {
    return new ElementFilter(current);
  }

  public SparqlExpressionBuilder and(Expr expression) {
    if (expression != null) {
      current = new E_LogicalAnd(current, expression);
    }
    return this;
  }

  public SparqlExpressionBuilder and(Expr expression, boolean condition) {
    if (condition) {
      return and(expression);
    }
    return this;
  }

  public SparqlExpressionBuilder or(Expr expression) {
    if (expression != null) {
      current = new E_LogicalOr(current, expression);
    }
    return this;
  }
}
