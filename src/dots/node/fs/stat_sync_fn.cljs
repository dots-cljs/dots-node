(ns dots.node.fs.stat-sync-fn
  (:refer-clojure :exclude [apply name]))

(defn apply
  "Calls the function, substituting the specified object for the this value of the function, and the specified array for the arguments of the function."
  (^js [stat-sync-fn this-arg]
   (.apply ^js stat-sync-fn this-arg))
  (^js [stat-sync-fn this-arg arg-array]
   (.apply ^js stat-sync-fn this-arg arg-array)))

(defn call
  "Calls a method of an object, substituting another object for the current object."
  ^js [stat-sync-fn this-arg & arg-array]
  (.. ^js stat-sync-fn -call (apply ^js stat-sync-fn (to-array (cons this-arg arg-array)))))

(defn bind
  "For a given function, creates a bound function that has the same body as the original function.
   The this object of the bound function is associated with the specified object, and has the specified initial parameters."
  ^js [stat-sync-fn this-arg & arg-array]
  (.. ^js stat-sync-fn -bind (apply ^js stat-sync-fn (to-array (cons this-arg arg-array)))))

(defn to-string
  "Returns a string representation of a function."
  ^js [stat-sync-fn]
  (.toString ^js stat-sync-fn))

(defn prototype
  ^js [stat-sync-fn]
  (.-prototype ^js stat-sync-fn))

(defn set-prototype!
  ^js [stat-sync-fn value]
  (set! (.-prototype ^js stat-sync-fn) value))

(defn length
  ^js [stat-sync-fn]
  (.-length ^js stat-sync-fn))

(defn arguments
  ^js [stat-sync-fn]
  (.-arguments ^js stat-sync-fn))

(defn set-arguments!
  ^js [stat-sync-fn value]
  (set! (.-arguments ^js stat-sync-fn) value))

(defn caller
  ^js [stat-sync-fn]
  (.-caller ^js stat-sync-fn))

(defn set-caller!
  ^js [stat-sync-fn value]
  (set! (.-caller ^js stat-sync-fn) value))

(defn name
  "Returns the name of the function. Function names are read-only and can not be changed."
  ^js [stat-sync-fn]
  (.-name ^js stat-sync-fn))
