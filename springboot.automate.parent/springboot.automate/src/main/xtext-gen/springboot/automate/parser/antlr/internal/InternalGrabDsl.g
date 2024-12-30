/*
 * generated by Xtext 2.32.0
 */
grammar InternalGrabDsl;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package springboot.automate.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package springboot.automate.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import springboot.automate.services.GrabDslGrammarAccess;

}

@parser::members {

 	private GrabDslGrammarAccess grammarAccess;

    public InternalGrabDslParser(TokenStream input, GrabDslGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected GrabDslGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='package'
		{
			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getPackageKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getPackageNameQualifiedNameParserRuleCall_1_0());
				}
				lv_packageName_1_0=ruleQualifiedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					set(
						$current,
						"packageName",
						lv_packageName_1_0,
						"springboot.automate.GrabDsl.QualifiedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getPackagesPackageDefinitionParserRuleCall_3_0());
				}
				lv_packages_3_0=rulePackageDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"packages",
						lv_packages_3_0,
						"springboot.automate.GrabDsl.PackageDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRulePackageDefinition
entryRulePackageDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPackageDefinitionRule()); }
	iv_rulePackageDefinition=rulePackageDefinition
	{ $current=$iv_rulePackageDefinition.current; }
	EOF;

// Rule PackageDefinition
rulePackageDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getPackageDefinitionAccess().getAnnotationsAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"springboot.automate.GrabDsl.Annotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='package'
		{
			newLeafNode(otherlv_1, grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPackageDefinitionAccess().getPackageNameQualifiedNameParserRuleCall_2_0());
				}
				lv_packageName_2_0=ruleQualifiedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
					}
					set(
						$current,
						"packageName",
						lv_packageName_2_0,
						"springboot.automate.GrabDsl.QualifiedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getPackageDefinitionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPackageDefinitionAccess().getClassesClassDefinitionParserRuleCall_4_0());
				}
				lv_classes_4_0=ruleClassDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
					}
					add(
						$current,
						"classes",
						lv_classes_4_0,
						"springboot.automate.GrabDsl.ClassDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getPackageDefinitionAccess().getInterfacesInterfaceDefinitionParserRuleCall_5_0());
				}
				lv_interfaces_5_0=ruleInterfaceDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
					}
					add(
						$current,
						"interfaces",
						lv_interfaces_5_0,
						"springboot.automate.GrabDsl.InterfaceDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getPackageDefinitionAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleClassDefinition
entryRuleClassDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getClassDefinitionRule()); }
	iv_ruleClassDefinition=ruleClassDefinition
	{ $current=$iv_ruleClassDefinition.current; }
	EOF;

// Rule ClassDefinition
ruleClassDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getClassDefinitionAccess().getAnnotationsAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getClassDefinitionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"springboot.automate.GrabDsl.Annotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='class'
		{
			newLeafNode(otherlv_1, grammarAccess.getClassDefinitionAccess().getClassKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getClassDefinitionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getClassDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_3='implements'
			{
				newLeafNode(otherlv_3, grammarAccess.getClassDefinitionAccess().getImplementsKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getClassDefinitionAccess().getInterfaceQualifiedNameParserRuleCall_3_1_0());
					}
					lv_interface_4_0=ruleQualifiedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getClassDefinitionRule());
						}
						set(
							$current,
							"interface",
							lv_interface_4_0,
							"springboot.automate.GrabDsl.QualifiedName");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getClassDefinitionAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getClassDefinitionAccess().getMembersMemberDefinitionParserRuleCall_5_0());
				}
				lv_members_6_0=ruleMemberDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getClassDefinitionRule());
					}
					add(
						$current,
						"members",
						lv_members_6_0,
						"springboot.automate.GrabDsl.MemberDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getClassDefinitionAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleInterfaceDefinition
entryRuleInterfaceDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInterfaceDefinitionRule()); }
	iv_ruleInterfaceDefinition=ruleInterfaceDefinition
	{ $current=$iv_ruleInterfaceDefinition.current; }
	EOF;

// Rule InterfaceDefinition
ruleInterfaceDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getInterfaceDefinitionAccess().getAnnotationsAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInterfaceDefinitionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"springboot.automate.GrabDsl.Annotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='interface'
		{
			newLeafNode(otherlv_1, grammarAccess.getInterfaceDefinitionAccess().getInterfaceKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getInterfaceDefinitionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getInterfaceDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getInterfaceDefinitionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getInterfaceDefinitionAccess().getMembersMemberDefinitionParserRuleCall_4_0());
				}
				lv_members_4_0=ruleMemberDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInterfaceDefinitionRule());
					}
					add(
						$current,
						"members",
						lv_members_4_0,
						"springboot.automate.GrabDsl.MemberDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getInterfaceDefinitionAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleMemberDefinition
entryRuleMemberDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMemberDefinitionRule()); }
	iv_ruleMemberDefinition=ruleMemberDefinition
	{ $current=$iv_ruleMemberDefinition.current; }
	EOF;

// Rule MemberDefinition
ruleMemberDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getMemberDefinitionAccess().getMethodMethodDefinitionParserRuleCall_0_0());
				}
				lv_method_0_0=ruleMethodDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMemberDefinitionRule());
					}
					set(
						$current,
						"method",
						lv_method_0_0,
						"springboot.automate.GrabDsl.MethodDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getMemberDefinitionAccess().getPropertyPropertyDefinitionParserRuleCall_1_0());
				}
				lv_property_1_0=rulePropertyDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMemberDefinitionRule());
					}
					set(
						$current,
						"property",
						lv_property_1_0,
						"springboot.automate.GrabDsl.PropertyDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleMethodDefinition
entryRuleMethodDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMethodDefinitionRule()); }
	iv_ruleMethodDefinition=ruleMethodDefinition
	{ $current=$iv_ruleMethodDefinition.current; }
	EOF;

// Rule MethodDefinition
ruleMethodDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getMethodDefinitionAccess().getAnnotationsAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMethodDefinitionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"springboot.automate.GrabDsl.Annotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMethodDefinitionAccess().getVisibilityVisibilityModifierParserRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMethodDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"springboot.automate.GrabDsl.VisibilityModifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getMethodDefinitionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMethodDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_3='('
		{
			newLeafNode(otherlv_3, grammarAccess.getMethodDefinitionAccess().getLeftParenthesisKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getMethodDefinitionAccess().getParametersParameterDefinitionParserRuleCall_4_0_0());
					}
					lv_parameters_4_0=ruleParameterDefinition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMethodDefinitionRule());
						}
						add(
							$current,
							"parameters",
							lv_parameters_4_0,
							"springboot.automate.GrabDsl.ParameterDefinition");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=','
				{
					newLeafNode(otherlv_5, grammarAccess.getMethodDefinitionAccess().getCommaKeyword_4_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMethodDefinitionAccess().getParametersParameterDefinitionParserRuleCall_4_1_1_0());
						}
						lv_parameters_6_0=ruleParameterDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMethodDefinitionRule());
							}
							add(
								$current,
								"parameters",
								lv_parameters_6_0,
								"springboot.automate.GrabDsl.ParameterDefinition");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_7=')'
		{
			newLeafNode(otherlv_7, grammarAccess.getMethodDefinitionAccess().getRightParenthesisKeyword_5());
		}
		otherlv_8=':'
		{
			newLeafNode(otherlv_8, grammarAccess.getMethodDefinitionAccess().getColonKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMethodDefinitionAccess().getReturnTypeTypeParserRuleCall_7_0());
				}
				lv_returnType_9_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMethodDefinitionRule());
					}
					set(
						$current,
						"returnType",
						lv_returnType_9_0,
						"springboot.automate.GrabDsl.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_10=';'
		{
			newLeafNode(otherlv_10, grammarAccess.getMethodDefinitionAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRulePropertyDefinition
entryRulePropertyDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyDefinitionRule()); }
	iv_rulePropertyDefinition=rulePropertyDefinition
	{ $current=$iv_rulePropertyDefinition.current; }
	EOF;

// Rule PropertyDefinition
rulePropertyDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAnnotationsAnnotationParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"springboot.automate.GrabDsl.Annotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getVisibilityVisibilityModifierParserRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"springboot.automate.GrabDsl.VisibilityModifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPropertyDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_3=':'
		{
			newLeafNode(otherlv_3, grammarAccess.getPropertyDefinitionAccess().getColonKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypeTypeParserRuleCall_4_0());
				}
				lv_type_4_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
					}
					set(
						$current,
						"type",
						lv_type_4_0,
						"springboot.automate.GrabDsl.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_5='='
			{
				newLeafNode(otherlv_5, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_5_0());
			}
			(
				(
					lv_defaultValue_6_0=RULE_STRING
					{
						newLeafNode(lv_defaultValue_6_0, grammarAccess.getPropertyDefinitionAccess().getDefaultValueSTRINGTerminalRuleCall_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPropertyDefinitionRule());
						}
						setWithLastConsumed(
							$current,
							"defaultValue",
							lv_defaultValue_6_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleParameterDefinition
entryRuleParameterDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterDefinitionRule()); }
	iv_ruleParameterDefinition=ruleParameterDefinition
	{ $current=$iv_ruleParameterDefinition.current; }
	EOF;

// Rule ParameterDefinition
ruleParameterDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getParameterDefinitionAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getParameterDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getParameterDefinitionAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterDefinitionAccess().getTypeTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterDefinitionRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"springboot.automate.GrabDsl.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3='='
			{
				newLeafNode(otherlv_3, grammarAccess.getParameterDefinitionAccess().getEqualsSignKeyword_3_0());
			}
			(
				(
					lv_defaultValue_4_0=RULE_STRING
					{
						newLeafNode(lv_defaultValue_4_0, grammarAccess.getParameterDefinitionAccess().getDefaultValueSTRINGTerminalRuleCall_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getParameterDefinitionRule());
						}
						setWithLastConsumed(
							$current,
							"defaultValue",
							lv_defaultValue_4_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleAnnotation
entryRuleAnnotation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationRule()); }
	iv_ruleAnnotation=ruleAnnotation
	{ $current=$iv_ruleAnnotation.current; }
	EOF;

// Rule Annotation
ruleAnnotation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='@'
		{
			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationAccess().getArgumentsAnnotationArgumentParserRuleCall_2_1_0_0());
						}
						lv_arguments_3_0=ruleAnnotationArgument
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationRule());
							}
							add(
								$current,
								"arguments",
								lv_arguments_3_0,
								"springboot.automate.GrabDsl.AnnotationArgument");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=','
					{
						newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAnnotationAccess().getArgumentsAnnotationArgumentParserRuleCall_2_1_1_1_0());
							}
							lv_arguments_5_0=ruleAnnotationArgument
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAnnotationRule());
								}
								add(
									$current,
									"arguments",
									lv_arguments_5_0,
									"springboot.automate.GrabDsl.AnnotationArgument");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleAnnotationArgument
entryRuleAnnotationArgument returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationArgumentRule()); }
	iv_ruleAnnotationArgument=ruleAnnotationArgument
	{ $current=$iv_ruleAnnotationArgument.current; }
	EOF;

// Rule AnnotationArgument
ruleAnnotationArgument returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getAnnotationArgumentAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationArgumentRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getAnnotationArgumentAccess().getEqualsSignKeyword_1());
		}
		(
			(
				lv_value_2_0=RULE_STRING
				{
					newLeafNode(lv_value_2_0, grammarAccess.getAnnotationArgumentAccess().getValueSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationArgumentRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleVisibilityModifier
entryRuleVisibilityModifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getVisibilityModifierRule()); }
	iv_ruleVisibilityModifier=ruleVisibilityModifier
	{ $current=$iv_ruleVisibilityModifier.current.getText(); }
	EOF;

// Rule VisibilityModifier
ruleVisibilityModifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='public'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getVisibilityModifierAccess().getPublicKeyword_0());
		}
		    |
		kw='private'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getVisibilityModifierAccess().getPrivateKeyword_1());
		}
		    |
		kw='protected'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getVisibilityModifierAccess().getProtectedKeyword_2());
		}
	)
;

// Entry rule entryRuleType
entryRuleType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current.getText(); }
	EOF;

// Rule Type
ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0());
		}
		this_PrimitiveType_0=rulePrimitiveType
		{
			$current.merge(this_PrimitiveType_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getQualifiedNameParserRuleCall_1());
		}
		this_QualifiedName_1=ruleQualifiedName
		{
			$current.merge(this_QualifiedName_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getGenericTypeParserRuleCall_2());
		}
		this_GenericType_2=ruleGenericType
		{
			$current.merge(this_GenericType_2);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimitiveType
entryRulePrimitiveType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeRule()); }
	iv_rulePrimitiveType=rulePrimitiveType
	{ $current=$iv_rulePrimitiveType.current.getText(); }
	EOF;

// Rule PrimitiveType
rulePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='void'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getVoidKeyword_0());
		}
		    |
		kw='String'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_1());
		}
		    |
		kw='double'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_2());
		}
		    |
		kw='float'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_3());
		}
		    |
		kw='int'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_4());
		}
		    |
		kw='UUID'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getUUIDKeyword_5());
		}
		    |
		kw='Date'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_6());
		}
		    |
		kw='Timestamp'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getTimestampKeyword_7());
		}
		    |
		kw='List'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrimitiveTypeAccess().getListKeyword_8());
		}
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleGenericType
entryRuleGenericType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getGenericTypeRule()); }
	iv_ruleGenericType=ruleGenericType
	{ $current=$iv_ruleGenericType.current.getText(); }
	EOF;

// Rule GenericType
ruleGenericType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getGenericTypeAccess().getQualifiedNameParserRuleCall_0());
		}
		this_QualifiedName_0=ruleQualifiedName
		{
			$current.merge(this_QualifiedName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getGenericTypeAccess().getLessThanSignKeyword_1());
		}
		{
			newCompositeNode(grammarAccess.getGenericTypeAccess().getTypeParserRuleCall_2());
		}
		this_Type_2=ruleType
		{
			$current.merge(this_Type_2);
		}
		{
			afterParserOrEnumRuleCall();
		}
		kw='>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getGenericTypeAccess().getGreaterThanSignKeyword_3());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
