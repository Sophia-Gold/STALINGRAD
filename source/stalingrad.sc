(MODULE STALINGRAD (WITH QOBISCHEME XLIB STALINGRADLIB-STUFF) (MAIN MAIN))
;;; LaHaShem HaAretz U'Mloah
;;; $Id$

;;; Stalingrad 0.1 - AD for VLAD, a functional language.
;;; Copyright 2004 and 2005 Purdue University. All rights reserved.

;;; This program is free software; you can redistribute it and/or
;;; modify it under the terms of the GNU General Public License
;;; as published by the Free Software Foundation; either version 2
;;; of the License, or (at your option) any later version.

;;; This program is distributed in the hope that it will be useful,
;;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;;; GNU General Public License for more details.

;;; You should have received a copy of the GNU General Public License
;;; along with this program; if not, write to the Free Software
;;; Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

;;; written by:
;;;    Jeffrey Mark Siskind
;;;    School of Electrical and Computer Engineering
;;;    Purdue University
;;;    465 Northwestern Avenue
;;;    Lafayette IN 47907-2035 USA
;;;    voice: +1 765 496-3197
;;;    FAX:   +1 765 494-6440
;;;    qobi@purdue.edu
;;;    ftp://ftp.ecn.purdue.edu/qobi
;;;    http://www.ece.purdue.edu/~qobi
;;;             and
;;;    Barak A. Pearlmutter
;;;    Hamilton Institute
;;;    National University of Ireland, Maynooth
;;;    Co. Kildare
;;;    Ireland
;;;    voice: +353 1 7086100
;;;    FAX:   +353 1 7086269
;;;    barak@cs.nuim.ie
;;;    http://www.bcl.hamilton.ie/~barak/

(include "QobiScheme.sch")
(include "stalingrad.sch")

(set! *program* "stalingrad")
(set! *panic?* #f)			;debugging

;;; Macros

;;; Structures

;;; Variables

;;; Parameters

;;; Procedures

;;; Commands

;;; Top Level

(define-command (main
		 (any-number
		  ("I"
		   include-path?
		   (include-path "include-directory" string-argument)))
		 (at-most-one ("letrec-as-y" letrec-as-y?))
		 (at-most-one ("flow-analysis" flow-analysis?))
		 (at-most-one ("undecorated" undecorated?))
		 (at-most-one ("metered" metered?))
		 (at-most-one ("show-access-indices" show-access-indices?))
		 (at-most-one
		  ("trace-primitive-procedures" trace-primitive-procedures?))
		 (at-most-one ("trace-nonrecursive-closures"
			       trace-nonrecursive-closures?))
		 (at-most-one
		  ("trace-recursive-closures" trace-recursive-closures?))
		 (at-most-one ("trace-argument/result" trace-argument/result?))
		 (at-most-one
		  ("unabbreviate-executably" unabbreviate-executably?)
		  ("unabbreviate-nicely" unabbreviate-nicely?))
		 (at-most-one ("unabbreviate-transformed"
			       unabbreviate-transformed?))
		 (at-most-one ("unabbreviate-nonrecursive-closures"
			       unabbreviate-nonrecursive-closures?))
		 (at-most-one ("unabbreviate-recursive-closures"
			       unabbreviate-recursive-closures?))
		 (at-most-one ("not-anal" not-anal?))
		 (at-most-one ("level" level? (level "n" integer-argument #f)))
		 (at-most-one
		  ("length" length? (write-length "n" integer-argument #f)))
		 (at-most-one ("pp" pp?))
		 (at-most-one ("cache-transformed-expressions"
			       cache-transformed-expressions?))
		 (at-most-one ("memoized" memoized?))
		 (at-most-one ("church-booleans" church-booleans?))
		 (at-most-one ("church-pairs" church-pairs?))
		 (at-most-one
		  ("l1" l1? (l1 "flow-size-limit" integer-argument #f)))
		 (at-most-one
		  ("l2" l2? (l2 "concrete-real-abstract-value-limit"
				integer-argument #f)))
		 (at-most-one
		  ("l3" l3? (l3 "matching-closure-abstract-value-limit"
				integer-argument #f)))
		 (at-most-one
		  ("l4"
		   l4?
		   (l4 "nonrec-closure-nesting-depth-limit"
		       integer-argument #f)
		   (l4-depth-measure "depth-measure" string-argument #f)))
		 (at-most-one
		  ("l5" l5? (l5 "matching-pair-abstract-value-limit"
				integer-argument #f)))
		 (at-most-one
		  ("l6" l6?
			(l6 "pair-nesting-depth-limit" integer-argument #f)))
		 (at-most-one
		  ("l7" l7? (l7 "matching-bundle-abstract-value-limit"
				integer-argument #f)))
		 (at-most-one
		  ("l8" l8?
			(l8 "bundle-nesting-depth-limit" integer-argument #f)))
		 (at-most-one ("track-flow-analysis" track-flow-analysis?))
		 (at-most-one
		  ("only-initialized-flows" only-initialized-flows?)
		  ("only-updated-bindings" only-updated-bindings?))
		 (at-most-one ("exclude-prior-values" exclude-prior-values?))
		 (at-most-one ("bypass-expand-defs" bypass-expand-defs?))
		 (at-most-one ("x" x? (x "variable" string-argument #f)))
		 (at-most-one ("no-warn" no-warn?))
		 (at-most-one ("expression-equality-using-identity"
			       expression-equality-using-identity?)
			      ("expression-equality-using-structural"
			       expression-equality-using-structural?)
			      ("expression-equality-using-alpha"
			       expression-equality-using-alpha?))
		 (at-most-one
		  ("checkpoint-at" checkpoint-at?
				   (i "iteration" integer-argument #f)))
		 (at-most-one ("checkpoint-doubles-imprecisely"
			       checkpoint-doubles-imprecisely?))
		 (at-most-one ("no-fast-letrec" no-fast-letrec?))
		 (at-most-one ("no-fast-cons" no-fast-cons?))
		 (at-most-one ("no-fast-apply" no-fast-apply?))
		 (at-most-one ("no-fast-apply-prime" no-fast-apply-prime?))
		 (at-most-one ("quiet" quiet?))
		 (at-most-one ("no-apply-multiply" no-apply-multiply?))
		 (at-most-one ("parse-abstract" parse-abstract?))
		 (at-most-one ("picky" picky?))
		 (at-most-one ("imprec-unroll" imprec-unroll?))
		 (at-most-one ("aesthetic" aesthetic?))
		 (at-most-one ("less-memory-output" less-memory-output?))
		 (at-most-one ("dont-output-result" dont-output-result?))
		 (required (pathname "pathname" string-argument)))
 (when (and unabbreviate-executably? unabbreviate-nonrecursive-closures?)
  (panic "Can't specify both -unabbreviate-executably and -unabbreviate-nonrecursive-closures"))
 (when (and unabbreviate-executably? unabbreviate-recursive-closures?)
  (panic "Can't specify both -unabbreviate-executably and -unabbreviate-recursive-closures"))
 (when (and church-booleans? (not church-pairs?))
  (panic "When you specify -church-booleans you must specify -church-pairs"))
 (set! *letrec-as-y?* letrec-as-y?)
 (set! *church-booleans?* church-booleans?)
 (set! *church-pairs?* church-pairs?)
 (when l1? (set! *l1* l1))
 (when l2? (set! *l2* l2))
 (when l3? (set! *l3* l3))
 (when l4?
  (set! *l4* l4)
  (set-l4-depth-measure-from-string! l4-depth-measure))
 (when l5? (set! *l5* l5))
 (when l6? (set! *l6* l6))
 (when l7? (set! *l7* l7))
 (when l8? (set! *l8* l8))
 (when (or expression-equality-using-identity?
	   expression-equality-using-structural?
	   expression-equality-using-alpha?)
  (set! *expression-equality-using-identity?*
	expression-equality-using-identity?)
  (set! *expression-equality-using-structural?*
	expression-equality-using-structural?)
  (set! *expression-equality-using-alpha?* expression-equality-using-alpha?))
 (when no-warn? (set! *warn?* #f))
 (when checkpoint-at?
  (set! *checkpoint-at?* checkpoint-at?)
  (set! *checkpoint-iteration* i))
 (set! *checkpoint-doubles-imprecisely?* checkpoint-doubles-imprecisely?)
 (set! *fast-letrec?* (not no-fast-letrec?))
 (set! *fast-cons?* (not no-fast-cons?))
 (set! *fast-apply?* (not no-fast-apply?))
 (set! *fast-apply-prime?* (not no-fast-apply-prime?))
 (set! *quiet?* quiet?)
 (set! *no-apply-multiply?* no-apply-multiply?)
 (set! *parse-abstract?* parse-abstract?)
 (set! *picky?* picky?)
 (set! *imprec-no-unroll?* (not imprec-unroll?))
 (set! *aesthetic-reduce-depth?* aesthetic?)
 (set! *track-flow-analysis?* track-flow-analysis?)
 (set! *only-initialized-flows?* only-initialized-flows?)
 (set! *only-updated-bindings?* only-updated-bindings?)
 (set! *include-prior-values?* (not exclude-prior-values?))
 (initialize-basis!)
 (set! *include-path*
       (append '(".") include-path '("/usr/local/stalingrad/include")))
 (set! *metered?* metered?)
 (set! *show-access-indices?* show-access-indices?)
 (set! *trace-primitive-procedures?* trace-primitive-procedures?)
 (set! *trace-nonrecursive-closures?* trace-nonrecursive-closures?)
 (set! *trace-recursive-closures?* trace-recursive-closures?)
 (set! *trace-argument/result?* trace-argument/result?)
 (set! *unabbreviate-executably?* unabbreviate-executably?)
 (set! *unabbreviate-nicely?* unabbreviate-nicely?)
 (set! *unabbreviate-transformed?* unabbreviate-transformed?)
 (set! *unabbreviate-nonrecursive-closures?*
       unabbreviate-nonrecursive-closures?)
 (set! *unabbreviate-recursive-closures?* unabbreviate-recursive-closures?)
 (set! *anal?* (not not-anal?))
 (set! *pp?* pp?)
 (when x? (set! *x* (read-from-string x)))
 (set! *cache-transformed-expressions?* cache-transformed-expressions?)
 (set! *memoized?* memoized?)
 (let loop ((es (read-source pathname)) (ds '()))
  (unless (null? es)
   (if (definition? (first es))
       (loop (rest es) (cons (first es) ds))
       (let ((e (if bypass-expand-defs?
		    (first es)
		    (expand-definitions (reverse ds) (first es)))))
	(syntax-check-expression! e)
	(let ((result (if *parse-abstract?* (parse-abstract e) (parse e))))
	 (when undecorated?
	  (pp (abstract->concrete (first result)))
	  (newline))
	 (cond
	  (flow-analysis?
	   (let ((bs (flow-analysis (first result) (second result))))
	    (when (not dont-output-result?)
	     (if less-memory-output?
		 (for-each (lambda (b)
			    (pp (externalize-abstract-expression-binding b))
			    (newline))
			   bs)
		 (begin (pp (externalize-abstract-analysis bs)) (newline))))))
	  (else
	   (when metered?
	    (for-each (lambda (b)
		       (let ((v (value-binding-value b)))
			(when (primitive-procedure? v)
			 (set-primitive-procedure-meter! v 0))))
		      *value-bindings*))
	   (with-write-level
	    level
	    (lambda ()
	     (with-write-length
	      write-length
	      (lambda ()
	       ((if *pp?* pp write)
		(externalize
		 (evaluate (first result)
			   'unspecified
			   (list->vector
			    (map value-binding-value (second result))))))))))
	   (newline)
	   (when metered?
	    (for-each (lambda (b)
		       (let ((v (value-binding-value b)))
			(when (and (primitive-procedure? v)
				   (not (zero? (primitive-procedure-meter v))))
			 (format #t "~a ~s~%"
				 (number->string-of-length
				  (primitive-procedure-meter v) 7)
				 (value-binding-variable b)))))
		      (reverse *value-bindings*))))))
	(loop (rest es) ds))))))

;;; Tam V'Nishlam Shevah L'El Borei Olam

;;; Local Variables:
;;; lisp-body-indent: 1
;;; End:
