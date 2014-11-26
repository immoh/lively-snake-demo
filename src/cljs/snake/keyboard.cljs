(ns snake.keyboard
  (:require clojure.string
            goog.events)
  (:import [goog.events KeyCodes KeyHandler]
           [goog.events.KeyHandler EventType]))


(def code->keyword (into {} (keep (fn [[k v]]
                                    (when-not (fn? v)
                                      [v (keyword (clojure.string/lower-case k))]))
                                  (js->clj KeyCodes))))

(defn listen! [valid-key? handler]
  (goog.events/listen (KeyHandler. js/document)
                      (.-KEY EventType)
                      (fn [event]
                        (let [key-name (code->keyword (.-keyCode event))]
                          (when (valid-key? key-name)
                            (handler key-name)
                            (.preventDefault event))))))

