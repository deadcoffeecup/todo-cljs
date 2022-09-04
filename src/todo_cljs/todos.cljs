(ns todo-cljs.todos 
  (:require [reagent.core :as reagent :refer [atom]]
            [clojure.edn :as edn])
  )

(def todos-state (atom [{:id 1 :desc "umyć zęby" :completed false}
                        {:id 2 :desc "umyć buzię" :completed false}]))

(def input-state (atom ""))
(defn parse-int [s]
  (edn/read-string s))

(defn handle-submit[e]
   (.preventDefault e)
  
                       (swap! todos-state conj {:id (inc (:id (peek @todos-state)) ) :desc @input-state :completed false}) 
                       (reset! input-state (-> "")) 
  )

;; 

(defn handle-click[e]
  (swap!  todos-state assoc-in [(dec(parse-int (.-id (.-target e)))) :completed]  true) 
  (println @todos-state)



  )

(defn todos-list []
 
  [:div
  [:ul
   (for [todo @todos-state]
     [:li  {:id (:id todo)  
            :style {:color (if (:completed todo) "green" "red")}
            :on-click (fn [e]
                        (handle-click e)
                        )
            :key (:id todo)} (:id todo) ". " (:desc todo)])]
  [:form {:on-submit (fn [e] 
                       (handle-submit e)) }
   [:input
    {:value @input-state
     :on-change #(reset! input-state (-> % .-target .-value))}]]]
  )



