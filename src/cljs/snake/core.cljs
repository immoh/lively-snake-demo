(ns snake.core
  (:require [reagent.core :as reagent]
            [snake.keyboard :as keyboard]))

(def cols 25)
(def rows 25)
(def unit-in-pixels 20)

(defonce game-state (reagent/atom {:running? false}))

(defn update-state [game-state]
  game-state)

(defn game-loop []
  (swap! game-state update-state)
  (when (:running? @game-state)
    (js/setTimeout game-loop 300)))

(defn start-game []
  (reset! game-state {:running? true
                      :snake [[15 15]
                              [16 15]
                              [17 15]
                              [18 15]
                              [19 15]]
                      :direction [-1 0]})
  (game-loop))

(defn start-screen []
  [:div {:style {:text-align "center"
                 :text-transform "uppercase"}}
   [:h1 {:style {:font-size (* 2 unit-in-pixels)
                 :padding-top (* 2 unit-in-pixels)}}
    "Snake"]
   [:a {:href "#"
        :style    {:font-size unit-in-pixels}
        :on-click (fn []
                    (start-game)
                    false)}
    "Start game"]])

(defn snake []
  [:div
   (map-indexed
     (fn [i [x y]]
       [:div {:style {:position "absolute"
                      :width (dec unit-in-pixels)
                      :height (dec unit-in-pixels)
                      :left (* x unit-in-pixels)
                      :top (* y unit-in-pixels)
                      :background-color "black"
                      :border "1px solid #ebebeb"}
              :key i}])
     (:snake @game-state))])

(defn apple []
  (let [[x y] (:apple @game-state)]
    [:div {:style {:position  "absolute"
                   :left (* x unit-in-pixels)
                   :top (* y unit-in-pixels)
                   :font-size unit-in-pixels
                   :color "green"}}
     ""]))

(defn game []
  [:div {:style {:width (* cols unit-in-pixels)
                 :height (* rows unit-in-pixels)
                 :background-color "#ebebeb"}}
   (if (:running? @game-state)
     [snake]
     [start-screen])])

(defn listen-to-arrow-keys []
  (keyboard/listen! #{:up :down :left :right}
                    (fn [key-name]
                      (swap! game-state assoc :direction (key-name {:up    [0 -1]
                                                                    :down  [0 1]
                                                                    :left  [-1 0]
                                                                    :right [1 0]})))))

(reagent/render-component [game] (.-body js/document))
